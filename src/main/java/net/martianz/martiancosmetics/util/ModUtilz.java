package net.martianz.martiancosmetics.util;

import net.minecraft.util.RandomSource;

public class ModUtilz {

    public static double rand(RandomSource randomSource, double min, double max){
        return min + (max - min) * randomSource.nextDouble();
    }
}
