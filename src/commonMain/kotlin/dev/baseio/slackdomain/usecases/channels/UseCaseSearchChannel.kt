package dev.baseio.slackdomain.usecases.channels


import dev.baseio.slackdomain.datasources.local.channels.SKLocalDataSourceReadChannels
import dev.baseio.slackdomain.model.channel.DomainLayerChannels
import dev.baseio.slackdomain.usecases.BaseUseCase
import kotlinx.coroutines.flow.Flow

class UseCaseSearchChannel(private val sdkDataSource: SKLocalDataSourceReadChannels) {
  operator fun invoke(params: UseCaseChannelRequest): Flow<List<DomainLayerChannels.SKChannel>> {
    return sdkDataSource.fetchChannelsOrByName(params.workspaceId, params.uuid)
  }
}
