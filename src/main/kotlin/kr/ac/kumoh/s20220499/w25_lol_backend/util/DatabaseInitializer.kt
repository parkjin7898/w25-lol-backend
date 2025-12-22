package kr.ac.kumoh.s20220499.w25_lol_backend.util

import kr.ac.kumoh.s20220499.w25_lol_backend.repository.ChampionRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DatabaseInitializer(private val repository: ChampionRepository) : CommandLineRunner {
    override fun run(vararg args: String?) {
        val champions = repository.findAll()
        var updatedCount = 0
        
        champions.forEach { champion ->
            if (champion.loadingImageUrl == null) {
                // Construct Loading Screen URL (No version number needed for loading images)
                // https://ddragon.leagueoflegends.com/cdn/img/champion/loading/Aatrox_0.jpg
                val englishName = champion.englishName
                champion.loadingImageUrl = "https://ddragon.leagueoflegends.com/cdn/img/champion/loading/${englishName}_0.jpg"
                repository.save(champion)
                updatedCount++
            }
        }
        
        if (updatedCount > 0) {
            println("=== Database Migration Complete: Updated $updatedCount champions with Loading Image URLs ===")
        }
    }
}
