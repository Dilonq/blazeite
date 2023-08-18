package djh.oil.block;

import djh.oil.OilMain;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block BLAZEITE_BLOCK = registerBlock("blazeite_block",
            new Block(FabricBlockSettings.of(Material.STONE).), ItemGroup.MISC);
//            new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(3.0f,3.0f).), ItemGroup.MISC);
//            new OreBlock(AbstractBlock.Settings.of(Material.STONE).requiresTool().strength(3.0f, 3.0f)));

    public static final Block IRON_ORE = Blocks.register("iron_ore",
            new OreBlock(AbstractBlock.Settings.of(Material.STONE).requiresTool().strength(3.0f, 3.0f)));

    private static Block registerBlock(String name, Block block, ItemGroup group){
        registerBlockItem(name, block, group);

        return Registry.register(Registry.BLOCK, new Identifier(OilMain.MODID, name), block);

    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group){
        return Registry.register(Registry.ITEM, new Identifier(OilMain.MODID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }
    public static void registerModBlocks(){
        OilMain.LOGGER.info("register ModBlocks for "+OilMain.MODID);
    }
}
