package kr.ac.kumoh.s20220499.w25_lol_backend.controller

import kr.ac.kumoh.s20220499.w25_lol_backend.model.Champion
import kr.ac.kumoh.s20220499.w25_lol_backend.service.ChampionService
import org.springframework.data.mongodb.core.aggregation.MergeOperation.UniqueMergeId.id
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/champions")
@CrossOrigin(origins = ["http://localhost:5173",
                        "https://parkjin7898.github.io"
])
class ChampionController(
    private val service: ChampionService
) {
    // 1. 모든 챔피언 목록을 조회
    // GET /api/champions 요청 시 호출된다.
    @GetMapping
    fun getAllChampions(): List<Champion> = service.getAllChampions()

    // 2. 특정 챔피언의 상세 정보를 조회
    @GetMapping("/{name}")
    fun getChampionByEnglishName(@PathVariable name: String): Champion?
            = service.getChampionByEnglishName(name)
}
