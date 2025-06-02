package net.nic.npc.kingdom.vars;

import com.mojang.serialization.Codec;

public enum Government {
    MONARCHY, FEUDALISM, DEMOCRACY, THEOCRACY, OLIGARCHY, DICTATORSHIP;

    public static final Codec<Government> CODEC = Codec.STRING.xmap(
            Government::valueOf,
            Government::name
    );

}