package kr.ac.kumoh.s20220499.w25_lol_backend.controller

import kr.ac.kumoh.s20220499.w25_lol_backend.model.Champion
import kr.ac.kumoh.s20220499.w25_lol_backend.service.ChampionService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/champions")
class ChampionController(
    private val service: ChampionService
) {
    @GetMapping
    fun getAllChampions(): List<Champion> = service.getAllChampions()

    @GetMapping("/{id}")
    fun getChampionById(@PathVariable id: String): Champion? = service.getChampionById(id)
}
