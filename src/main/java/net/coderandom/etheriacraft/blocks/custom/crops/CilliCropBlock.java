package net.coderandom.etheriacraft.blocks.custom.crops;

import net.coderandom.etheriacraft.items.custom.ModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class CilliCropBlock extends CropBlock {
    public static int MAX_AGE = 7;
    public static IntegerProperty AGE = BlockStateProperties.AGE_7;
    public static Item SEED_ITEM;
    public CilliCropBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission());
    }

    @Override
    public IntegerProperty getAgeProperty() { return AGE; }

    @Override
    public int getMaxAge() { return MAX_AGE; }

    @Override
    protected ItemLike getBaseSeedId() { return ModItems.CHILLI_SEEDS.get(); }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
