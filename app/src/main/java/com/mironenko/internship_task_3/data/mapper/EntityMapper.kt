package com.mironenko.internship_task_3.data.mapper

interface EntityMapper<Entity, Model> {

    fun mapFromEntity(entity: Entity): Model

    fun fromEntityList(initial: List<Entity>): List<Model>
}