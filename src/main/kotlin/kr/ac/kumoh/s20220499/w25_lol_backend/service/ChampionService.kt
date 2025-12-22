package kr.ac.kumoh.s20220499.w25_lol_backend.service

import kr.ac.kumoh.s20220499.w25_lol_backend.model.Champion
import kr.ac.kumoh.s20220499.w25_lol_backend.repository.ChampionRepository
import org.springframework.data.mongodb.core.aggregation.MergeOperation.UniqueMergeId.id
import org.springframework.stereotype.Service

@Service
class ChampionService(
    private val repository: ChampionRepository
) {
    // 모든 챔피언 조회
    fun getAllChampions(): List<Champion>
            = repository.findAll()
    // ID로 조회
    fun getChampionById(id: String): Champion?
            = repository.findById(id).orElse(null)
    // [핵심] 영문명으로 챔피언 조회
    // 상세정보 조회할때 URL 파라미터로 챔피언의 영문명을 받기 때문
    fun getChampionByEnglishName(englishName: String): Champion?
            = repository.findByEnglishName(englishName)
}
