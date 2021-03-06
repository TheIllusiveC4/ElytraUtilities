/*
 * Copyright (C) 2022 C4
 *
 * This file is part of Elytra Utilities.
 *
 * Elytra Utilities is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Elytra Utilities is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * and the GNU Lesser General Public License along with Elytra Utilities.
 * If not, see <https://www.gnu.org/licenses/>.
 *
 */

package top.theillusivec4.elytrautilities.client;

import net.minecraftforge.client.event.MovementInputUpdateEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.gui.ForgeIngameGui;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@SuppressWarnings("unused")
public class ClientEventsListener {

  public static void setup() {
    MinecraftForge.EVENT_BUS.register(new ClientEventsListener());
  }

  @SubscribeEvent
  public void clientTick(final TickEvent.ClientTickEvent evt) {

    if (evt.phase == TickEvent.Phase.END) {
      ClientEvents.clientTick();
    }
  }

  @SubscribeEvent
  public void input(final MovementInputUpdateEvent evt) {
    ClientEvents.triggerFlight(evt.getPlayer(), evt.getInput());
  }

  @SubscribeEvent
  public void onRenderGameOverlay(final RenderGameOverlayEvent.PostLayer evt) {

    if (evt.getOverlay() == ForgeIngameGui.POTION_ICONS_ELEMENT) {
      ClientEvents.renderIcon(evt.getMatrixStack());
    }
  }
}
