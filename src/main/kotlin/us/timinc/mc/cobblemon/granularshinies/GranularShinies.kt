package us.timinc.mc.cobblemon.granularshinies

import com.cobblemon.mod.common.api.spawning.spawner.PlayerSpawnerFactory
import net.minecraftforge.event.server.ServerStartedEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.Mod.EventBusSubscriber
import us.timinc.mc.cobblemon.granularshinies.config.ConfigBuilder
import us.timinc.mc.cobblemon.granularshinies.config.MainConfig
import us.timinc.mc.cobblemon.granularshinies.influences.ShinyOverride

@Mod(GranularShinies.MOD_ID)
object GranularShinies {
    const val MOD_ID = "granularshinies"
    var config: MainConfig = ConfigBuilder.load(MainConfig::class.java, MOD_ID)

    @EventBusSubscriber(bus = EventBusSubscriber.Bus.FORGE)
    object Registration {
        @SubscribeEvent
        fun onInit(e: ServerStartedEvent) {
            PlayerSpawnerFactory.influenceBuilders.add(::ShinyOverride)
        }
    }
}