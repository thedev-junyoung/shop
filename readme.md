# **RunShop - 온라인 쇼핑몰 시스템**
## **목차**
1. [프로젝트 개요](#%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-%EA%B0%9C%EC%9A%94)
2. [주요 기능](#%EC%A3%BC%EC%9A%94-%EA%B8%B0%EB%8A%A5)
3. [시스템 요구 사항](#%EC%8B%9C%EC%8A%A4%ED%85%9C-%EC%9A%94%EA%B5%AC-%EC%82%AC%ED%95%AD)
4. [설치 및 실행 가이드](#%EC%84%A4%EC%B9%98-%EB%B0%8F-%EC%8B%A4%ED%96%89-%EA%B0%80%EC%9D%B4%EB%93%9C)
    - [1. 저장소 클론](#1-%EC%A0%80%EC%9E%A5%EC%86%8C-%ED%81%B4%EB%A1%A0)
    - [2. 환경 설정](#2-%ED%99%98%EA%B2%BD-%EC%84%A4%EC%A0%95)
    - [3. Docker 컨테이너 실행](#3-docker-%EC%BB%A8%ED%85%8C%EC%9D%B4%EB%84%88-%EC%8B%A4%ED%96%89)
    - [4. 애플리케이션 빌드 및 실행](#4-%EC%95%A0%ED%94%8C%EB%A6%AC%EC%BC%80%EC%9D%B4%EC%85%98-%EB%B9%8C%EB%93%9C-%EB%B0%8F-%EC%8B%A4%ED%96%89)
    - [5. 테스트 실행](#5-%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%8B%A4%ED%96%89)
5. [추가 정보](#%EC%B6%94%EA%B0%80-%EC%A0%95%EB%B3%B4)

---
## **프로젝트 개요**
RunShop은 사용자가 상품을 조회하고, 장바구니에 담아 주문 및 결제를 진행할 수 있는 기능을 제공하는 온라인 쇼핑몰 시스템입니다. 사용자는 판매자로 등록하여 상품을 업로드하고 관리할 수 있습니다.

---
## **주요 기능**
### 1. **회원 관리**
- **회원 가입 및 로그인**: 사용자가 회원 가입 후 로그인할 수 있습니다.
- **프로필 관리**: 사용자가 자신의 정보를 수정할 수 있습니다.
- **판매자 등록**: 판매자로 등록 신청 후 관리자의 승인을 받을 수 있습니다.
### 2. **상품 관리**
- **상품 등록/수정/삭제**: 판매자가 상품을 관리할 수 있습니다.
- **상품 조회 및 검색**: 사용자가 상품을 조회하고 검색할 수 있습니다.
### 3. **장바구니 및 주문**
- **장바구니 추가**: 사용자가 상품을 장바구니에 추가할 수 있습니다.
- **주문 생성 및 결제**: 주문 생성 시 재고 확인 후 결제를 처리합니다.
- **주문 상태 관리**: 배송 상태 변경 및 주문 취소를 할 수 있습니다.
### 4. **관리자 기능**
- **사용자 및 판매자 관리**: 관리자가 사용자를 관리하고 판매자 등록을 승인할 수 있습니다.
- **주문 관리**: 전체 주문 내역을 조회하고 관리할 수 있습니다.

---

## **시스템 요구 사항**
- Java 17
- Gradle 7.4 이상
- Docker 및 Docker Compose
- MySQL
- Redis
- H2 데이터베이스 (개발 및 테스트 용)

---

## **설치 및 실행 가이드**
### **1. 저장소 클론**
```bash
git clone https://github.com/thedev-junyoung/RunShop.git cd RunShop
```

### **2. 환경 설정**
#### `.env` 파일 생성:
- 프로젝트 루트 디렉토리에 `.env` 파일을 생성하여 중요한 환경 변수를 관리합니다. 아래 템플릿을 참고하세요:
```bash
# MySQL 설정
DB_USERNAME=your_db_username
DB_PASSWORD=your_db_password

# JWT 비밀 키
JWT_SECRET=your_jwt_secret

# Redis 설정
REDIS_HOST=localhost
REDIS_PORT=6379
```
> 이 파일은 `.gitignore`에 추가하여 Git에 포함되지 않도록 설정합니다.
### **3. Docker 컨테이너 실행**
#### MySQL 및 Redis 시작:
- 이 프로젝트는 `docker-compose`를 사용하여 MySQL과 Redis 서비스를 실행합니다. 아래 명령어로 개발 환경을 구성하세요:
```bash
docker-compose up -d
```
#### 컨테이너 실행 상태 확인:
```bash
docker ps
```
> MySQL과 Redis가 정상적으로 실행 중인지 확인하세요.
### **4. 애플리케이션 빌드 및 실행**
#### 프로젝트 빌드:

애플리케이션을 실행하기 전에 Gradle을 사용하여 빌드를 진행합니다:
```bash
./gradlew clean build
```
#### 개발 모드에서 애플리케이션 실행:
빌드가 완료되면 다음 명령어로 애플리케이션을 실행합니다:
```bash
./gradlew bootRun -Dspring.profiles.active=dev
```
### **5. 테스트 실행**
테스트 환경에서 테스트를 실행하려면 다음 명령어를 사용하세요:

``` bash
./gradlew test -Dspring.profiles.active=test
```

### **주요 기술 스택**:
- **Spring Boot**: 백엔드 프레임워크
- **Spring Security**: 인증 및 권한 관리
- **Redis**: 캐시 관리
- **H2**: 인메모리 데이터베이스 (개발 및 테스트용)
- **MySQL**: 메인 데이터베이스 (프로덕션 환경)
- **Docker**: 컨테이너 환경 구축