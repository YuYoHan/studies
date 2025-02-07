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
