package com.brendanofawesome.mendingminingfix.mixins;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(MultiPlayerGameMode.class)
public class MultiPlayerGameModeMixin {

    //replace the method call to "sameDestroyTarget" from https://mcsrc.dev/2/26.3/net/minecraft/client/multiplayer/MultiPlayerGameMode#L309
    @WrapOperation(
        method = "sameDestroyTarget",
        at = @At(
            value = "INVOKE", 
            target = "Lnet/minecraft/world/item/ItemStack;isSameItemSameComponents(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/ItemStack;)Z"
        )
    )
    private static boolean wrapSameDestroyTargetCheck(ItemStack stack1, ItemStack stack2, Operation<Boolean> original) {
        //ignore type differences if type == DAMAGE
        return ItemStack.matchesIgnoringComponents(stack1, stack2, type -> type == DataComponents.DAMAGE);
    }
}