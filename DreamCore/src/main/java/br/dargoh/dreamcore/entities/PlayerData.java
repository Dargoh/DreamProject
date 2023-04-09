package br.dargoh.dreamcore.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nivixx.ndatabase.api.annotation.NTable;
import com.nivixx.ndatabase.api.model.NEntity;

import java.util.UUID;

@NTable(name = "player_data", schema = "", catalog = "")
public class PlayerData extends NEntity<UUID> {

    @JsonProperty("kills")
    private int kills;

    @JsonProperty("deaths")
    private int deaths;

}
