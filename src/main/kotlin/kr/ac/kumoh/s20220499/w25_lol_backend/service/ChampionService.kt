package kr.ac.kumoh.s20220499.w25_lol_backend.service

import kr.ac.kumoh.s20220499.w25_lol_backend.model.Champion
import kr.ac.kumoh.s20220499.w25_lol_backend.repository.ChampionRepository
import org.springframework.data.mongodb.core.aggregation.MergeOperation.UniqueMergeId.id
import org.springframework.stereotype.Service

@Service
class ChampionService(
    private val repository: ChampionRepository
) {
    fun getAllChampions(): List<Champion> = repository.findAll()
    fun getChampionById(id: String): Champion? = repository.findById(id).orElse(null)
    fun getChampionByEnglishName(englishName: String): Champion? = repository.findByEnglishName(englishName)

    // Add more methods as needed, e.g., for data initialization
    fun saveChampion(champion: Champion): Champion {
        return repository.save(champion)
    }
}
