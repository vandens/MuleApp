
package com.my.Helper.serviceObject;

/**
 *
 * @author Vandens mc Maddens
 */
public class ServiceObject{
    

static class ChannelHeader{
	public String $messageID;
	public String $additionalHeader;
	public String $branchCode;
	public String $channelID;
	public String $clientSupervisorID;
	public String $clientUserID;
	public String $reference;
	public String $transactiondate;
	public String $transactiontime;
	public String $reversalsequenceno;
	public String $sequenceno;
}

static class EFT_MT103Request{
	public String $filler2;
	public String $MT_103_Filler1;
	public String $MT_103_RECV_BIC;
	public String $MT_103_RECV_BRCH;
	public String $MT_103_SW20;
	public String $MT_103_SW32A;
	public String $MT_103_SW50_1;
	public String $MT_103_SW50_2;
	public String $MT_103_SW50_3;
	public String $MT_103_SW50_4;
	public String $MT_103_SW50_5;
	public String $MT_103_SW52A;
	public String $MT_103_SW57A;
	public String $MT_103_SW57D_1;
	public String $MT_103_SW57D_2;
	public String $MT_103_SW57D_3;
	public String $MT_103_SW57D_4;
	public String $MT_103_SW59_1;
	public String $MT_103_SW59_2;
	public String $MT_103_SW59_3;
	public String $MT_103_SW59_4;
	public String $MT_103_SW59_5;
	public String $MT_103_SW70_1;
	public String $MT_103_SW70_2;
	public String $MT_103_SW70_3;
	public String $MT_103_SW70_4;
	public String $MT_103_SW71A;
	public String $MT_103_SW72_1;
	public String $MT_103_SW72_2;
	public String $MT_103_SW72_3;
	public String $MT_103_SW72_4;
	public String $MT_103_SW72_5;
	public String $MT_103_SW72_6;
	public String $MT_103_Send_BIC;
	public String $MT_103_Send_BRCH;
	public String $MUR_T108;
}

static class verifyCorporateCR_HSMRequest{
	public String $tk_corporateid;
	public String $tk_corporateuserid;
	public String $tk_hash;
	public String $tk_value;
}


static class verifyCorporateCR_HSM{
	public String $ChannelHeader;
	public String $verifyCorporateCR_HSMRequest;
}

static class MT103{
	public String $ChannelHeader;
	public String $SystematicTrxData;
	public String $EFT_MT103Request;
}

}