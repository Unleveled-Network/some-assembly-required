package someassemblyrequired.common.ingredient;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import someassemblyrequired.common.init.ModItems;
import someassemblyrequired.common.init.ModSoundEvents;
import someassemblyrequired.common.util.Util;

public class PotionProperties extends IngredientProperties {

    private static final ItemStack CONTAINER = new ItemStack(Items.GLASS_BOTTLE);

    private final ItemStack displayItem;

    public PotionProperties() {
        super(null, null, null, ItemStack.EMPTY, ItemStack.EMPTY, ModSoundEvents.ADD_SPREAD.get());
        displayItem = new ItemStack(ModItems.SPREAD.get());
        displayItem.getOrCreateTag();
    }

    @Override
    public ItemStack getDisplayItem(ItemStack item) {
        Potion potion = PotionUtils.getPotion(item);
        // noinspection ConstantConditions
        displayItem.getTag().putBoolean("HasEffect", potion != Potions.WATER);
        displayItem.getTag().putInt("Color", PotionUtils.getColor(potion));
        return displayItem;
    }

    @Override
    public Component getDisplayName(ItemStack item) {
        Potion potion = PotionUtils.getPotion(item);
        if (!item.hasCustomHoverName() && potion == Potions.WATER) {
            return Util.translate("ingredient.water_bottle");
        }
        return super.getDisplayName(item);
    }

    @Override
    public Component getFullName(ItemStack item) {
        if (PotionUtils.getPotion(item) == Potions.WATER) {
            return getDisplayName(item);
        }
        return super.getFullName(item);
    }

    @Override
    public ItemStack getContainer(ItemStack item) {
        return CONTAINER;
    }
}
