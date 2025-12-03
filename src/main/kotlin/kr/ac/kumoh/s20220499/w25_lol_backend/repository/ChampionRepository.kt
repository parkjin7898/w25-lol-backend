package kr.ac.kumoh.s20220499.w25_lol_backend.repository

import kr.ac.kumoh.s20220499.w25_lol_backend.model.Champion
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ChampionRepository : MongoRepository<Champion, String>
