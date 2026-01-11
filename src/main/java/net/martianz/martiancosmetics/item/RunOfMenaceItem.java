package net.martianz.martiancosmetics.item;

import net.martianz.martiancosmetics.particle.ModParticles;
import net.martianz.martiancosmetics.util.ModUtilz;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class RunOfMenaceItem extends Item implements ICurioItem {

    public RunOfMenaceItem(Properties properties) {
        super(properties.stacksTo(1));
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        LivingEntity entity = slotContext.entity();
        Level level = entity.level();

        double min = -1.0d;
        double max = 1.0d;
        double rx = ModUtilz.rand(level.getRandom(), min, max);
        double ry = ModUtilz.rand(level.getRandom(), min, max);
        double rz = ModUtilz.rand(level.getRandom(), min, max);
        double chance = ModUtilz.rand(level.getRandom(), 0, 100);

        if(!level.isClientSide && slotContext.visible() && chance > 70){
            Vec3 pos = entity.position();
            ((ServerLevel)level).sendParticles(ModParticles.MENACE_PARTICLE.get(),
                    pos.x+rx, pos.y+1.0d+ry, pos.z+rz, 1, 0, 0, 0, 0.01d);
        }
    }


}
