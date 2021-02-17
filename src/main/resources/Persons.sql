IF OBJECT_ID('cardDetail') IS NOT NULL
  DROP TABLE cardDetail
 CREATE TABLE cardDetail
 (
 id INT IDENTITY(1,1) PRIMARY KEY,
 cardNO VARCHAR(8),
 NAME VARCHAR(30),
 idCard VARCHAR(18),
 cardState CHAR(1)--卡片状态 1合格 0不合格
 )
  INSERT cardDetail(cardNO,NAME,idCard,cardState)
 VALUES
 ('001','张三','31010',0),
 ('001','张三','31010',1),
 ('002','李四','31011',0),
 ('003','王五','31019',1),
 ('001','张三','31014',0),
 ('003','王五','31012',1),
 ('004','欧阳','31013',0),
 ('004','欧阳','31013',1),
 ('001','张三','31014',0),
 ('001','张三','31014',1),
 ('002','李四','31011',1),
 ('003','王五','31016',1),
 ('001','张三','31015',0),
 ('003','王五','31012',1),
 ('004','欧阳','31017',1),
 ('004','欧阳','31018',0)


delete a
 from cardDetail a
 where exists(select 1
              from cardDetail b
              where b.cardNO=a.cardNO and b.idcard=a.idcard
              and b.id>a.id)


select * from dbo.cardDetail

/*
id          cardNO   NAME       idCard     cardState
----------- -------- ---------- ---------- ---------
2           001      张三         31010      1
4           003      王五         31019      1
8           004      欧阳         31013      1
10          001      张三         31014      1
11          002      李四         31011      1
12          003      王五         31016      1
13          001      张三         31015      0
14          003      王五         31012      1
15          004      欧阳         31017      1
16          004      欧阳         31018      0

(10 row(s) affected)
*/


delete from PerSons
where name,age in (select name,age from PerSons group by name and age having count(*) > 1)
and id not in (select max(id) from PerSons group by name and age having count(*)>1)
/*
语句解释：
找出有重复的记录，并查出其中id号最小的id:
select min(id) from SimNetInfo group by imsi having count(imsi)>1　

找出所有重复记录的imsi，并按关键字分组：
select imsi from SimNetInfo group by imsi having count(imsi) > 1

删除所有的有重复的imsi　并将最小的id的那一条排除。
 */