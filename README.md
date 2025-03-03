# Check List Project

체크리스트 프로젝트입니다.

## 📌 프로젝트 개요
- **프로젝트명**: Check List
- **버전**: 0.0.1-SNAPSHOT
- **개발 언어**: Java 17
- **빌드 도구**: Gradle
- **프레임워크**: Spring Boot 3.4.3
- **데이터베이스**: H2 Database (개발 환경)

## 🛠 기술 스택
- **Backend**
    - Java 17
    - Spring Boot 3.4.3
    - Spring Security
    - Spring Data JPA
    - H2 Database (개발 환경)
- **Frontend**
    - Thymeleaf
    - Thymeleaf Extras Spring Security
- **빌드 & 의존성 관리**
    - Gradle (Dependency Management Plugin 사용)
- **기타**
    - Lombok (개발 편의성 향상)
    - Spring Boot DevTools (개발 환경 개선)
    - JUnit & Spring Security Test (테스트 코드 지원)

## 📌 문서
### API 앤드포인트 문서
- [API 엔드포인트 문서](https://docs.google.com/spreadsheets/d/1O4Lt4XLUSuWpnqbprD0W4OX3QSt-zPvkV9g9qBqqtTA/edit?gid=0#gid=0)

### erd
- [테이블 정의서](https://docs.google.com/spreadsheets/d/1O4Lt4XLUSuWpnqbprD0W4OX3QSt-zPvkV9g9qBqqtTA/edit?gid=1430982991#gid=1430982991)
```mermaid
erDiagram
    user ||--o{ check_item : has
    check_item ||--o{ check_item_log : has
    user ||--o{ check_item_log : has
    user {
        bigint user_seq PK "auto_increment"
        varchar(20) user_id "unique not null"
        varchar(255) password "not null"
        datetime created_at "not null"
        datetime modified_at
        tinyint user_state "not null, {INACTIVE(0)|ACTIVE(1)}"
        datetime last_login_at
        tinyint login_fail_count
        datetime last_login_try_at
    }
  check_item {
        bigint check_item_id PK "auto_increment"
        varchar(50) check_item_name "not null"
        tinyint interval_type "not null, {DAILY(0)|PERIODIC(1)|WEEKLY(2)}"
        time check_item_time "not null"
        tinyint check_item_status "not null, {INACTIVE(0)|ACTIVE(1)}"
        datetime created_at "not null"
        bigint created_by "not null fk"
        datetime modified_at
        bigint modified_by "fk"
    }
    check_item_log {
        bigint check_item_log_id PK "auto_increment"
        bigint check_item_id "fk"
        tinyint check_status "not null, {UNCHECKED(0)|CHECKED(1)}"
        datetime created_at "not null"
        bigint created_by "not null fk"
        datetime modified_at
        bigint modified_by "fk"
    }

```