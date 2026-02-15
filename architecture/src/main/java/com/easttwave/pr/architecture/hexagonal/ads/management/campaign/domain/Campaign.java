package com.easttwave.pr.architecture.hexagonal.ads.management.campaign.domain;

import com.easttwave.pr.architecture.hexagonal.ads.management.shared.domain.DateRange;

public class Campaign {

    private CampaignId id;

    private String name;

    private CampaignObjective objective;  // CONVERSION, AWARENESS, TRAFFIC

//    private Budget totalBudget;

    private DateRange period;

    private CampaignStatus status;

//    private List<AdSet> adSets;  // 1:N
}
