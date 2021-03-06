/*******************************************************************************
 *     Copyright (C) 2015 Jordan Dalton (jordan.8474@gmail.com)
 *
 *     This program is free software; you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation; either version 2 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License along
 *     with this program; if not, write to the Free Software Foundation, Inc.,
 *     51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 *******************************************************************************/
package ovh.tgrhavoc.aibot.protocol.v5x.play.server;

import java.io.*;

import ovh.tgrhavoc.aibot.IntHashMap;
import ovh.tgrhavoc.aibot.protocol.*;
import ovh.tgrhavoc.aibot.protocol.ProtocolX.State;
import ovh.tgrhavoc.aibot.world.entity.WatchableObject;

public class PacketS0F_SpawnMob extends AbstractPacketX implements ReadablePacket {
	private int entityId, type;
	private double x, y, z, yaw, pitch, headYaw;
	private double velocityX, velocityY, velocityZ;
	private IntHashMap<WatchableObject> metadata;

	public PacketS0F_SpawnMob() {
		super(0x0F, State.PLAY, Direction.DOWNSTREAM);
	}

	@Override
	public void readData(DataInputStream in) throws IOException {
		entityId = readVarInt(in);
		type = in.read();

		x = in.readInt() / 32D;
		y = in.readInt() / 32D;
		z = in.readInt() / 32D;
		yaw = (in.readByte() * 360) / 256D;
		pitch = (in.readByte() * 360) / 256D;
		headYaw = (in.readByte() * 360) / 256D;

		velocityX = in.readShort() / 8000D;
		velocityY = in.readShort() / 8000D;
		velocityZ = in.readShort() / 8000D;

		metadata = readWatchableObjects(in);
	}

	public int getEntityId() {
		return entityId;
	}

	public int getType() {
		return type;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}

	public double getYaw() {
		return yaw;
	}

	public double getPitch() {
		return pitch;
	}

	public double getHeadYaw() {
		return headYaw;
	}

	public double getVelocityX() {
		return velocityX;
	}

	public double getVelocityY() {
		return velocityY;
	}

	public double getVelocityZ() {
		return velocityZ;
	}

	public IntHashMap<WatchableObject> getMetadata() {
		return metadata;
	}
}
