package kr.ac.kumoh.s20220499.w25_lol_backend.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = "champions")
data class Champion(
    @Id
    val _id: String? = null,

    @Field("id")
    val englishName: String,
    val key: String,
    val name: String,
    val title: String,
    val blurb: String,
    val info: Map<String, Int>,
    val image: Map<String, Any>,
    val tags: List<String>,
    val partype: String,
    val stats: Map<String, Double>,

    var loadingImageUrl: String? = null
)
