package dev.baseio.slackdomain.datasources.local.users

import dev.baseio.slackdomain.model.users.DomainLayerUsers
import kotlinx.coroutines.flow.Flow

interface SKLocalDataSourceUsers {
    fun getUsersFlow(workspace: String): Flow<List<DomainLayerUsers.SKUser>>
    fun getUsers(workspace: String): List<DomainLayerUsers.SKUser>
    fun getUser(workspaceId: String, uuid: String): DomainLayerUsers.SKUser?
    fun saveUser(senderInfo: DomainLayerUsers.SKUser?)
}