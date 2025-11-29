package eu.magkari.mc.chiikawa;

import net.fabricmc.api.ClientModInitializer;

import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.resources.ResourceLocation;

public class EmotionalSupportChiikawa implements ClientModInitializer {
	public static final String MOD_ID = "chiikawa";

	public static final ResourceLocation CHIIKAWA = ResourceLocation.fromNamespaceAndPath(MOD_ID, "hud/chiikawa");

	@Override
	public void onInitializeClient() {
		HudElementRegistry.attachElementAfter(VanillaHudElements.CHAT, ResourceLocation.fromNamespaceAndPath(MOD_ID, "chiikawa_hud"), EmotionalSupportChiikawa::render);
	}

	private static void render(GuiGraphics context, DeltaTracker deltaTracker) {
		int windowWidth = Minecraft.getInstance().getWindow().getScreenWidth();
		context.blitSprite(RenderPipelines.GUI_TEXTURED, CHIIKAWA, windowWidth/150, windowWidth/150, windowWidth/20, windowWidth/20);
	}
}