package com.lss233.phoenix.entity;

import com.lss233.phoenix.utils.Identifiable;
import com.lss233.phoenix.world.Location;
import com.lss233.phoenix.world.Locatable;
import com.sun.istack.internal.Nullable;

import java.util.List;
import java.util.Optional;
import java.util.Vector;


/**
 * An entity is a Minecraft entity.
 */
public interface Entity extends Locatable, Identifiable {

    /**
     * Gets the type of this entity.
     * @return The type of this entity.
     */
    EntityTypes getType();


    /**
     * Checks if the given entity is a passenger.
     * @param entity The entity passenger.
     * @return If it is a passenger.
     */
    boolean hasPassenger(Entity entity);

    /**
     * Gets the entity passenger that rides this entity, if available.
     * @return The passenger entity, if it exists
     */
    List<Entity> getPassengers();

    /**
     * Sets the passenger entity(the entity that rides this one).
     * @param entity The entity passenger, or null to eject
     * @return If adding the passenger succeeded
     */
    boolean addPassenger(Entity entity);

    /**
     * Removes all currently riding passengers from this entity.
     */
    void clearPassengers();
    /**
     * Removes the given entity as a passenger.
     * @param entity The entity to remove as passenger
     */
    void removePassenger(Entity entity);


    /**
     * Gets the entity vehicle that this entity is riding, if available.
     * @return The vehicle entity, if it exists
     */
    Optional<Vehicle> getVehicle();

    /**
     * Sets the vehicle entity(the entity that is ridden by this one).
     * @param entity The entity vehicle, or null to dismount
     * @return True if the set was successful
     */
    boolean setVehicle(@Nullable Entity entity);

    /**
     * Gets the entity vehicle that is the base of what ever stack
     * the current entity is a part of. This can be the current entity,
     * if it is not riding any vehicle.
     The returned entity can never ride another entity, that would make
     the ridden entity the base of the stack.
     * @return The vehicle entity, if available
     */
    Entity getBaseVehicle();


    /**
     * Gets this entity's current velocity.
     * @return The current velocity
     */
    Vector getVelocity();


    /**
     * Returns whether this entity has gravity.
     * @return True if this entity has gravity
     */
    boolean gravity();
    /**
     * Teleports this entity to the given location.
     * @param location position
     * @return True if the teleport was successful.
     */
    boolean teleport(Location location);

    /**
     * Teleports this entity to the target Entity.
     * @param entity entity
     * @return True if the teleport was successful.
     */
    boolean teleport(Entity entity);


}
