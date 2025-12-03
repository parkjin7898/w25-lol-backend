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
@CrossOrigin(origins = ["http://localhost:5173"])
class ChampionController(
    private val service: ChampionService
) {
    @GetMapping
    fun getAllChampions(): List<Champion> = service.getAllChampions()

    @GetMapping("/{id}")
    fun getChampionByName(@PathVariable name: String): Champion? = service.getChampionByName(name)
}
