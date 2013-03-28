package mekanism.common;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class ItemDust extends ItemMekanism
{
	public Icon[] icons = new Icon[256];
	public static String[] en_USNames = {"Iron", "Gold", "Osmium", 
										"Obsidian", "Diamond", "Steel",
										"Copper", "Tin", "Silver"};
	
	public ItemDust(int id)
	{
		super(id);
		setHasSubtypes(true);
		setCreativeTab(Mekanism.tabMekanism);
	}
	
	@Override
	public void updateIcons(IconRegister register)
	{
		for(int i = 0; i <= 8; i++)
		{
			icons[i] = register.registerIcon("mekanism:" + en_USNames[i] + "Dust");
		}
	}

	@Override
	public Icon getIconFromDamage(int meta)
	{
		return icons[meta];
	}

	@Override
	public void getSubItems(int id, CreativeTabs tabs, List itemList)
	{
		for (int counter = 0; counter <= 8; ++counter)
		{
			itemList.add(new ItemStack(this, 1, counter));
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return "item." + en_USNames[item.getItemDamage()].toLowerCase() + "Dust";
	}
}