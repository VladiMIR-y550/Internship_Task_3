package com.mironenko.internship_task_3.data.mapper

interface EntityMapper<ResponseEntity, DbEntity, ModelEntity> {

    fun responseEntityToDbEntity(responseEntity: ResponseEntity): DbEntity
    fun dbEntityToUser(dbEntity: DbEntity): ModelEntity

    fun fromDbEntityList(initial: List<DbEntity>): List<ModelEntity>
    fun fromResponseEntityList(initial: List<ResponseEntity>): List<DbEntity>
}