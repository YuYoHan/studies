# 공부한 내용
- OAuth2.0
- Artillery
- Spring Batch


---
# Artillery
K6와 더불어 부하 테스트를 할 수 있는 툴이다. <br/>
Artillery는 **부하 테스트(Load Testing)**와 **성능 테스트(Performance Testing)**를 수행하기 위한 오픈 소스 도구입니다. 주로 HTTP, WebSocket, Socket.io 등 다양한 프로토콜 기반 애플리케이션의 성능을 테스트하고, 애플리케이션이 높은 트래픽을 처리할 수 있는지 검증하는 데 사용됩니다.

Artillery는 사용하기 쉽고 확장 가능하며, JavaScript를 기반으로 한 설정 및 스크립팅을 통해 복잡한 시나리오를 작성할 수 있도록 설계되었습니다.

---
<<<<<<< HEAD

=======
# Pessimistic Lock
비관적인 락으로 동시성 문제 해결

---
#  Optimistic Lock 
낙관적인 락으로 동시성 문제 해결

![image](https://github.com/user-attachments/assets/1e49c723-80e8-4411-af89-ad44f3e7e168)

---
# Named lock
네임드 락으로 동시성 문제 해결

## 🔒 Named Lock (이름 기반 락)란?
Named Lock은 특정 이름을 가진 락을 획득하는 방식으로, 주로 데이터베이스에서 동시성 제어를 위해 사용됩니다.
MySQL, PostgreSQL 등의 RDBMS에서 제공하는 기능이며, 같은 이름을 가진 락을 요청하는 트랜잭션들은 순차적으로 실행되도록 보장합니다.

## 📌 Named Lock 특징
특정 리소스(데이터)가 아닌 "이름"을 기반으로 락을 설정

일반적인 Pessimistic Lock이나 Optimistic Lock은 레코드 단위로 동작하지만, Named Lock은 이름 기반으로 적용됩니다.
트랜잭션 단위가 아닌 세션(Session) 단위로 유지

일반적인 락은 트랜잭션이 종료되면 해제되지만, Named Lock은 세션이 종료될 때까지 유지됩니다.
락을 명시적으로 해제(RELEASE_LOCK())하지 않으면, 해당 세션이 종료될 때까지 락이 유지됨.
동시성 제어를 위한 강력한 수단

특정 로직이 동시에 실행되지 않도록 보장하는 경우에 유용합니다.
분산 환경에서 특정 자원에 대한 동시 접근을 막기 위해 사용됨.

## 🛠 Named Lock을 지원하는 DBMS
![image](https://github.com/user-attachments/assets/9ceceeaf-91c1-4320-97a8-99a4660f7355)


---
# Redis
## 레디스로 동시성 문제 해결
### Lettuce
- setnx 명령어를 활용하여 분산락 구현 <br/>
- spin lcok 방식
### Rdisson
pub-sub 기반으로 lock 구현 제공

## 레디스 공부
```shell
# redis설치(linux)
sudo apt-get install redis-server
# redis접속
redis-cli

# redis도커설치(윈도우, mac)
docker run --name redis-container -d -p 6379:6379 redis
# docker 컨네이너 조회
docker ps
# redis도커 접속
docker exec -it <containerID> redis-cli

# redis는 0~15번까지의 database로 구성(default는 0번 db)
# 데이터베이스 선택
select db번호

# 데이터베이스내 모든 키 조회
keys *

# 일반적인 String 자료구조

# set을 통해 key:value 세팅.
set user:email:1 hong1@naver.com
set user:email:2 "hong2@naver.com"
# nx : 이미존재하면 pass, 없으면 set 
set user:email:1 hong1@naver.com nx
# ex : 만료시간(초단위) - ttl(time to live)
set user:email:1 hong1@naver.com ex 10
# redis활용 : refresh토큰등 사용자 인증정보 저장
set user:1:refresh_token eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9 ex 10000
# get을 통해 value값 얻기
get user:1:refresh_token

# 특정 key삭제
del user:email:1
# 현재 DB내 모든 key삭제
flushdb

# redis활용 : 좋아요기능 구현
set likes:posting:1 0
incr likes:posting:1 #특정 key값의 value를 1만큼 증가
decr likes:posting:1 #특정 key값의 value를 1만큼 감소
get likes:posting:1
# redis활용 : 재고관리(동시성이슈 해결)
set stocks:product:1 100
decr stocks:product:1
get stocks:product:1

# redis활용 : 캐싱 기능 구현
# 1번 member 회원 정보 조회
# select name, email, age from member where id=1;
# 위 데이터의 결과값을 redis로 캐싱 -> json형식으로 저장 {"name":"hong", "email":"hong@daum.net", "age":30}
set member:info:1 "{\"name\":\"hong\", \"email\":\"hong@daum.net\", \"age\":30}" ex 20

# list자료구조
# redis의 list는 deque와 같은 자료구조, 즉 doueble-ended queue구조

# lpush : 데이터를 왼쪽에 삽입
# rpush : 데이터를 오른쪽에 삽입
# lpop : 데이터를 왼쪽에서 꺼내기
# rpop : 데이터를 오른쪽에서 꺼내기
lpush hongildongs hong1
lpush hongildongs hong2
rpush hongildongs hong3
rpop hongildongs
lpop hongildongs

# list조회
# -1은 리스트의 끝자리를 의미. -2는 끝에서 2번째를 의미.
lrange hongildongs 0 0 #첫번째값
lrange hongildongs -1 -1 #마지막값
lrange hongildongs 0 -1 #처음부터마지막
lrange hongildongs -3 -1 #마지막3번째부터 마지막까지
lrange hongildongs 0 2

# 데이터 개수 조회
llen hongildongs
# ttl 적용
expire hongildongs 20
# ttl 조회
ttl hongildongs
# pop과 push를 동시에
# A리스트에서 POP하여 B리스트로 PUSH
rpoplpush A리스트 B리스트

# redis활용 : 최근 방문한 페이지
# 5개정도 데이터 push
# 최근방문한 페이지 3개만 보여주는
rpush mypages www.naver.com
rpush mypages www.google.com
rpush mypages www.daum.net
rpush mypages www.chatgpt.com
rpush mypages www.daum.net
lrange mypages -3 -1

# set자료구조 : 중복없음. 순서없음.
sadd memberlist member1
sadd memberlist member2
sadd memberlist member1

# set 조회
smembers memberlist
# set멤버 개수 조회
scard memberlist 
# set에서 멤버 삭제
srem memberlist member2
# 특정 멤버가 set안에 있는지 존재여부 확인
sismember memberlist member1

# redis활용 : 좋아요 구현
sadd likes:posting:1 member1
sadd likes:posting:1 member2
sadd likes:posting:1 member1
scard likes:posting:1
sismember likes:posting:1 member1

# zset : sorted set
# 사이에 숫자는 score라고 불리고, score를 기준으로 정렬
zadd memberlist 3 member1
zadd memberlist 4 member2
zadd memberlist 1 member3
zadd memberlist 2 member4

# 조회방법
# score기준 오름차순 정렬
zrange memberlist 0 -1
# score기준 내림차순 정렬
zrevrange memberlist 0 -1

# zset삭제
zrem memberlist member4

# zrank : 특정 멤버가 몇번째(index 기준) 순서인지 출력
zrank memberlist member4

# redis 활용 : 최근 본 상품목록
# zset을 활용해서 최근시간순으로 정렬
# zset도 set이므로 같은 상품을 add할 경우에 시간만 업데이트되고 중복이 제거
# 같은 상품을 더할경우 시간만 마지막에 넣은 값으로 업데이트(중복제거)
zadd recent:products 151930 pineapple
zadd recent:products 152030 banana
zadd recent:products 152130 orange
zadd recent:products 152230 apple
zadd recent:products 152330 apple
# 최근본 상품목록 3개 조회
zrevrange recent:products 0 2
zrevrange recent:products 0 2 withscores

# redis활용사례 : 주식시세저장
# 종목명: 삼성전자, 시세: 72000원, 시간: 1672527600 (유닉스 타임스탬프) -> 년월일시간을 초단위로 변환한것.(밀리초 단위도 가능능)
zadd stock:prices:samsung 1672527600 "53000"
# 종목명: LG전자, 시세: 95000원, 시간: 1672527660
zadd stock:prices:lg 1672527660 "95000"
# 종목명: 삼성전자, 시세: 72500원, 시간: 1672527720
zadd stock:prices:samsung 1672527720 "72500"
# 종목명: LG전자, 시세: 94500원, 시간: 1672527780
zadd stock:prices:lg 1672527780 "94500"
# 삼성전자의 최신 시세 조회 (최대 1개)
zrevrange stock:prices:samsung 0 0 withscores

# hashes : map형태의 자료구조(key:value key:value ... 형태의 자료구조)
hset author:info:1 name hong email hong@naver.com age 30
# 특정값 조회
hget author:info:1 name
# 모든 객체값 조회
hgetall author:info:1
# 특정 요소값 수정
hset author:info:1 name kim

# 

```
>>>>>>> 4ad0a86af3b6aad2742e2de3c544b5aebd357b9d
