package dev.baseio.slackdata.injection

import dev.baseio.slackdomain.usecases.auth.*
import dev.baseio.slackdomain.usecases.chat.UseCaseSendMessage
import dev.baseio.slackdomain.usecases.channels.*
import dev.baseio.slackdomain.usecases.chat.UseCaseFetchAndUpdateChangeInMessages
import dev.baseio.slackdomain.usecases.chat.UseCaseFetchAndSaveMessages
import dev.baseio.slackdomain.usecases.chat.UseCaseFetchMessages
import dev.baseio.slackdomain.usecases.users.UseCaseFetchLocalUsers
import dev.baseio.slackdomain.usecases.users.UseCaseFetchAndSaveUsers
import dev.baseio.slackdomain.usecases.workspaces.*
import org.koin.dsl.module

val useCaseModule = module {
    single { LoginUseCase(get(), get()) }
    single { FindWorkspacesUseCase(get()) }
    single { UseCaseFetchAndSaveWorkspaces(get(), get()) }
    single { UseCaseGetWorkspaces(get()) }
    single { UseCaseSetLastSelectedWorkspace(get()) }
    single { UseCaseFetchRecentChannels(get()) }
    single { UseCaseGetSelectedWorkspace(get()) }
    single { UseCaseFetchAndSaveChannels(get(), get()) }
    single { UseCaseFetchChannelsWithLastMessage(get()) }
    single { UseCaseFetchAndUpdateChangeInMessages(get(), get(), get()) }
    single { UseCaseFetchAndSaveMessages(get(), get(), get()) }
    single { UseCaseSendMessage(get(), get()) }
    single { UseCaseFetchMessages(get(), get()) }
    single { UseCaseFetchAllChannels(get()) }
    single { UseCaseCreateChannel(get(), get()) }
    single { UseCaseCreateOneToOneChannel(get()) }
    single { UseCaseGetChannel(get()) }
    single { UseCaseFetchChannelCount(get()) }
    single { UseCaseSearchChannel(get()) }
    single { UseCaseFetchLocalUsers(get()) }
    single { UseCaseFindChannelById(get(), get(), get()) }
    single { UseCaseFetchAndSaveUsers(get(), get()) }
    single { UseCaseLogout(get(), get()) }
    single { UseCaseCurrentUser(get()) }
    single { UseCaseCreateWorkspace(get(), get(), get(), get()) }
    single { UseCaseRegisterUser(get(), get(), get()) }
}