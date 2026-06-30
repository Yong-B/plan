## 📌 API 명세서 (Plan API)

| 기능 | Method | URL | Request Body / Query Param | Response Status |
| :--- | :--- | :--- | :--- | :--- |
| **일정 생성** | `POST` | `/api/plans` | [Request Body](#1-일정-생성-request-body) | `201 Created` |
| **일정 전체 조회** | `GET` | `/api/plans` | [Query Parameter](#2-일정-전체-조회-query-parameter) | `200 OK` |
| **일정 선택 조회** | `GET` | `/api/plans/{Id}` | *None* (Path Variable) | `200 OK` |
| **일정 수정** | `PATCH` | `/api/plans/{Id}` | [Request Body](#4-일정-수정-request-body) | `200 OK` |
| **일정 삭제** | `DELETE` | `/api/plans/{Id}` | [Request Body](#5-일정-삭제-request-body) | `204 No Content` |


## 2. 상세 API 명세 (JSON Specs)
[API 명세서 메모장 확인하기](./docs/api-specs.txt)

## 📌 ERD
<img width="486" height="310" alt="image" src="https://github.com/user-attachments/assets/2e2aaa42-9237-4563-b2f0-67c296029113" />

---

## 3 Layer Architecture 적용 확인 및 필요성

#### 🛠️ 프로젝트 적용 확인
 Controller, Service, Repository로 역할을 분리한 3 Layer Architecture를 적용했습니다.

- Controller: 클라이언트의 HTTP 요청을 받고 응답을 반환합니다.
- Service: 일정 생성, 조회, 수정, 삭제와 같은 핵심 비즈니스 로직을 처리합니다.
- Repository: JPA를 이용하여 데이터베이스에 접근합니다.

### 이러한 구조가 필요한 이유
계층을 분리함으로써 각 클래스의 책임을 명확히 하고, 코드의 유지보수성과 확장성을 높일 수 있습니다.

---

## Annotation 정리

- `@RequestParam`: URL의 Query Parameter 값을 받을 때 사용합니다. 작성자명 조건 조회처럼 선택적인 검색 조건에 사용했습니다.
- `@PathVariable`: URL 경로에 포함된 값을 받을 때 사용합니다. 일정 ID를 이용한 단건 조회, 수정, 삭제에 사용했습니다.
- `@RequestBody`: HTTP Body의 JSON 데이터를 DTO 객체로 변환할 때 사용합니다. 일정 생성, 수정, 삭제 요청 데이터를 받을 때 사용했습니다.
