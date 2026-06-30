## 📌 API 명세서 (Plan API)

| 기능 | Method | URL | Request Body / Query Param | Response Status |
| :--- | :--- | :--- | :--- | :--- |
| **일정 생성** | `POST` | `/api/plans` | [Request Body](#1-일정-생성-request-body) | `201 Created` |
| **일정 전체 조회** | `GET` | `/api/plans` | [Query Parameter](#2-일정-전체-조회-query-parameter) | `200 OK` |
| **일정 선택 조회** | `GET` | `/api/plans/{Id}` | *None* (Path Variable) | `200 OK` |
| **일정 수정** | `PATCH` | `/api/plans/{Id}` | [Request Body](#4-일정-수정-request-body) | `200 OK` |
| **일정 삭제** | `DELETE` | `/api/plans/{Id}` | [Request Body](#5-일정-삭제-request-body) | `204 No Content` |


## 2. 상세 API 명세 (JSON Specs)
### 1. 일정 생성
* **URL**: `POST /api/plans`
* **Request Body (PlanCreateRequestDto)**
```json
{
  "title": "최용범 두 번째 일정",
  "content": "작성자 조건 조회 테스트",
  "author": "최용범",
  "password": "1234"
}[Uploading ## 2. 상세 API 명세 (JSON Specs).txt…]()
