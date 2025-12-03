# 구현 계획서: 롤 챔피언 정보 앱

## 목표
Riot Games의 챔피언 데이터를 MongoDB에 구축하고, Spring Boot 백엔드와 React 프론트엔드를 통해 챔피언 목록 및 상세 정보를 제공하는 웹 애플리케이션 개발.

## 사용자 검토 필요 사항 (User Review Required)
> [!IMPORTANT]
> **데이터 구조 변경**: 원본 JSON은 챔피언 ID를 키로 하는 Map 형태(`{"Aatrox": {...}}`)입니다. MongoDB 쿼리 효율성과 리스트 출력을 위해 이를 **배열 형태(`[{ "id": "Aatrox", ... }]`)로 변환**하여 저장하는 것을 강력히 권장합니다. 제가 이 변환 작업을 수행하는 스크립트를 작성해 드릴 수 있습니다.

## 제안된 변경 사항 (Proposed Changes)

### 데이터 전처리 (Data Preprocessing)
- **원본 데이터**: `https://ddragon.leagueoflegends.com/cdn/14.23.1/data/ko_KR/champion.json`
- **변환 작업**:
    - `data` 객체의 값들만 추출하여 리스트로 변환.
    - 이미지 URL 경로를 클라이언트에서 쉽게 사용할 수 있도록 기본 URL(`https://ddragon.leagueoflegends.com/cdn/14.23.1/img/champion/`)을 고려하여 데이터 정제.

### 백엔드 (Spring Boot + Kotlin)
- **언어**: Kotlin (JDK 17+)
- **패키지 구조**:
    - `com.example.w25lolbackend.domain`: `Champion` (Data Class, Document)
    - `com.example.w25lolbackend.repository`: `ChampionRepository` (MongoRepository)
    - `com.example.w25lolbackend.controller`: `ChampionController`
    - `com.example.w25lolbackend.service`: `ChampionService`
- **API 명세**:
    - `GET /api/champions`: 모든 챔피언 목록 반환 (ID, 이름, 이미지, 타이틀 등 요약 정보)
    - `GET /api/champions/{id}`: 특정 챔피언의 상세 정보 반환

### 프론트엔드 (React)
- **기술 스택**: Vite, React, Tailwind CSS, React Router, TanStack Query
- **페이지 구조**:
    - `/`: 챔피언 목록 페이지 (카드 그리드 레이아웃, 검색 기능)
    - `/champions/:id`: 챔피언 상세 페이지 (배경 스킨 이미지, 스탯 그래프, 스토리)
- **디자인**:
    - 롤 클라이언트와 유사한 다크 테마.
    - 골드/블루 계열의 포인트 컬러.
    - 부드러운 호버 효과 및 페이지 전환 애니메이션.

## 검증 계획 (Verification Plan)
### 자동화 테스트
- 백엔드: `ChampionController` 단위 테스트 (MockMvc).
- 프론트엔드: 브라우저 도구를 이용한 렌더링 및 API 호출 확인.

### 수동 검증
- MongoDB Atlas 컬렉션 데이터 확인.
- 브라우저에서 리스트 로딩 및 상세 페이지 이동 확인.
- 반응형 레이아웃 확인.
