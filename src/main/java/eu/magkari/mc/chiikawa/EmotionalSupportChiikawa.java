package eu.magkari.mc.chiikawa;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmotionalSupportChiikawa implements ClientModInitializer {
	public static final String MOD_ID = "chiikawa";

	public static final Identifier CHIIKAWA = Identifier.of(MOD_ID, "hud/chiikawa");

	@Override
	public void onInitializeClient() {
		HudElementRegistry.attachElementAfter(VanillaHudElements.CHAT, Identifier.of(MOD_ID, "chiikawa_hud"), EmotionalSupportChiikawa::render);
	}

	private static void render(DrawContext context, RenderTickCounter tickCounter) {
		int windowWidth = MinecraftClient.getInstance().getWindow().getWidth();
		context.drawGuiTexture(RenderPipelines.GUI_TEXTURED, CHIIKAWA, windowWidth/150, windowWidth/150, windowWidth/20, windowWidth/20);
	}
}