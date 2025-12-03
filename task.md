# 과제 #2: 롤 챔피언 정보 앱 개발

## 데이터베이스 (MongoDB Atlas)
- [x] 챔피언 데이터 준비
    - [x] Riot API에서 JSON 다운로드 (Script로 수행)
    - [x] `data` 맵 구조를 문서 배열(Array of Documents)로 변환 (전처리)
    - [x] 필요한 필드 추출 (id, name, title, image, blurb, stats 등)
- [x] MongoDB Atlas에 데이터 가져오기 (Import)
    - [x] 클러스터 및 데이터베이스 생성
    - [x] `champions` 컬렉션 생성
    - [x] 전처리된 JSON 파일 Import

## 백엔드 (Spring Boot + Kotlin)
- [/] Spring Boot 프로젝트 초기화 (사용자가 생성함: `w25-lol-backend`)
    - [x] 의존성: Spring Web, Spring Data MongoDB, Lombok (Kotlin에서는 data class 사용)
- [ ] 도메인 모델 구현
    - [ ] MongoDB 문서 구조와 매핑되는 `Champion` 클래스 생성
- [ ] 리포지토리 구현
    - [ ] `ChampionRepository` 인터페이스 생성
- [ ] 서비스/컨트롤러 구현
    - [ ] `GET /api/champions`: 챔피언 목록 반환 (요약 정보)
    - [ ] `GET /api/champions/{id}`: 챔피언 상세 정보 반환
- [ ] CORS 설정 (프론트엔드 접근 허용)

## 프론트엔드 (React + Vite)
- [ ] React 프로젝트 초기화
    - [ ] Vite, React, Tailwind CSS, React Router, TanStack Query
- [ ] API 클라이언트 구현
    - [ ] Axios 또는 fetch를 사용하여 백엔드 API 연동
- [ ] 챔피언 목록 페이지 생성
    - [ ] 챔피언 그리드/리스트 조회 및 표시
    - [ ] 이미지 및 이름 표시
- [ ] 챔피언 상세 페이지 생성
    - [ ] 상세 정보 조회 및 표시 (스탯, 설명 등)
- [ ] 스타일링 및 완성도 높이기
    - [ ] "프리미엄" 디자인 적용 (다크 모드, 애니메이션)

## 제출 준비
- [ ] 요구사항 검증
- [ ] 실행 화면 캡처
- [ ] 보고서 작성 (목표, 구현 현황, 어려웠던 점)
