package kr.ac.kumoh.s20220499.w25_lol_backend.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

// MongoDB 컬렉션 매핑
@Document(collection = "champions")
data class Champion(
    @Id
    val _id: String? = null,

    // DB 필드 매핑 및 필드 정의
    @Field("id")
    val englishName: String, // 실제 DB의 'id' 필드를 'englishName' 변수에 매핑
    val key: String,
    val name: String,
    val title: String,
    val blurb: String,
    val info: Map<String, Int>, // 공격/마법/방어/난이도 정보
    val image: Map<String, Any>, // 기본 이미지 정보
    val tags: List<String>,
    val partype: String,
    val stats: Map<String, Double>, // 상세 스탯

    // 로딩 이미지 URL 저장을 위한 추가 필드
    var loadingImageUrl: String? = null
)
