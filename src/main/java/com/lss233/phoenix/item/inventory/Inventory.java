package com.lss233.phoenix.item.inventory;

import com.lss233.phoenix.utils.Nameable;

/**
 * Base interface for queryable inventories.
 */
public interface Inventory extends Nameable {

    /**
     * Creates a new {@link Inventory.Builder} to build an {@link Inventory}.
     * @return The builder.
     */
    static Inventory.Builder builder(){
        return new Builder();
    }

    /**
     * Clears this inventory.
     */
    void clear();

    /**
     * Checks whether the stacks quantity or more of given stack is contained in this Inventory.
     * @param itemStack The item to check for
     * @return True if there are at least the given stack's amount of items present in this inventory.
     */
    boolean contains(ItemStack itemStack);

    /**
     * Checks for whether there is a stack in this Inventory with the given ItemType.
     * @param itemType The type to check for
     * @return True if at least one stack in this list has the given type
     */
    boolean contains(ItemType itemType);

    /**
     * Checks whether the given stack is contained in this Inventory. The stack size is ignored.
     * @param itemStack The item to check for
     * @return True if the stack is present in this inventory
     */
    boolean containsAny(ItemStack itemStack);

    /**
     * Gets the maximum size of any stack in this Inventory.
     * @return The maximum size of any stack in this Inventory.
     */
    int getMaxStackSize();

    /**
     * Gets the maximum number of  {@link ItemStack} the Inventory can hold.
     * @return The maximum number of  {@link ItemStack} the Inventory can hold.
     */
    int capacity();

    /**
     * Gets the number of {@link ItemStack} currently in the Inventory.
     * @return The number of {@link ItemStack} currently in the Inventory.
     */
    int size();

    /**
     * Gets the inventory type of this inventory.
     * @return The inventory type.
     */
    InventoryType getInventoryType();

    /**
     * A Builder for {@link Inventory}.
     */
    static class Builder {
    }
}
