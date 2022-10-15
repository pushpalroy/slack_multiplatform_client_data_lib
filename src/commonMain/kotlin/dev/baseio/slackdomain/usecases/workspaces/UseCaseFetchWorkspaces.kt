package dev.baseio.slackdomain.usecases.workspaces

import dev.baseio.slackdata.protos.KMSKWorkspace
import dev.baseio.slackdata.protos.KMSKWorkspaces
import dev.baseio.slackdomain.datasources.local.workspaces.SKLocalDataSourceReadWorkspaces
import dev.baseio.slackdomain.datasources.local.workspaces.SKLocalDataSourceWriteWorkspaces
import dev.baseio.slackdomain.datasources.remote.workspaces.SKNetworkDataSourceReadWorkspaces
import dev.baseio.slackdomain.model.workspaces.DomainLayerWorkspaces
import kotlinx.coroutines.flow.*

class UseCaseFetchWorkspaces(
    private val skNetworkDataSourceReadWorkspaces: SKNetworkDataSourceReadWorkspaces,
    private val skLocalDataSourceWriteWorkspaces: SKLocalDataSourceWriteWorkspaces,
    private val skLocalDataSourceReadWorkspaces: SKLocalDataSourceReadWorkspaces
) {
    suspend operator fun invoke(): Flow<List<DomainLayerWorkspaces.SKWorkspace>> {
        return kotlin.runCatching {
            val kmSKWorkspaces = skNetworkDataSourceReadWorkspaces.getWorkspaces()
            skLocalDataSourceWriteWorkspaces.saveWorkspaces(kmSKWorkspaces.workspacesList.map { kmskWorkspace ->
                kmskWorkspace.toSKWorkspace()
            })
        }.run {
            // TODO notify upstream of any errors!
            skLocalDataSourceReadWorkspaces.fetchWorkspaces()
        }
    }
}

fun KMSKWorkspace.toSKWorkspace(): DomainLayerWorkspaces.SKWorkspace {
    return DomainLayerWorkspaces.SKWorkspace(this.uuid, this.name, this.domain, this.picUrl, this.modifiedTime)
}
