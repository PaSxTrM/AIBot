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
package ovh.tgrhavoc.aibot.protocol.v78.packets;

import java.io.*;

import ovh.tgrhavoc.aibot.protocol.WriteablePacket;

public class Packet12PlayerLook extends Packet10Flying implements WriteablePacket {
	public float yaw;
	public float pitch;

	public Packet12PlayerLook() {
	}

	public Packet12PlayerLook(float par1, float par2, boolean par3) {
		super(par3);
		yaw = par1;
		pitch = par2;
	}

	@Override
	public void writeData(DataOutputStream out) throws IOException {
		out.writeFloat(yaw);
		out.writeFloat(pitch);
		super.writeData(out);
	}

	@Override
	public int getId() {
		return 12;
	}
}
