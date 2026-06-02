package org.ncm.ncmv2.api.service;

import org.apache.logging.log4j.Logger;
import org.ncm.ncmv2.domain.dao.NetDao;
import org.ncm.ncmv2.domain.dto.CreateNetDto;
import org.ncm.ncmv2.domain.dto.NetEntryDto;
import org.ncm.ncmv2.domain.dto.StationLookupDto;
import org.ncm.ncmv2.domain.model.Net;
import org.ncm.ncmv2.domain.model.NetEntry;
import org.ncm.ncmv2.domain.model.NetType;
import org.ncm.ncmv2.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

@Service
public class NetService {

    @Autowired
    NetDao netDao;

    @Autowired
    private Logger logger;
    @Autowired
    private StationService stationService;

    /**
     * CreateNewNet accepts a CreateNetDTO and builds a new net accordingly.
     * This function does NOT generate pre-built nets, since those do not automatically open upon creation.
     *
     * @param netDto - A DTO object with the basic setup information for a net
     * @return Net
     */
    public Net createNewNet(CreateNetDto netDto) {
        // Build the initial net object from the DTO
        Net buildNet = Net.builder()
                .name(netDto.getName())
                .netType(netDto.getNetType())
                .startTime(OffsetDateTime.now(ZoneOffset.UTC))
                .publicNet(netDto.isPublicNet())
                .owner(netDto.getOwner())
//                .group(netDto.getGroup())
                .frequency(netDto.getFrequency())
                .build();

        Net newNet = netDao.createNet(buildNet);
        logger.info("New Net Created.  NET ID: {}; Owner: {}", newNet.getId(), newNet.getOwner().getCallsign());

        // Add the


        return newNet;
    }

    public NetEntry createNetEntry(NetEntryDto netEntryDto) {
        NetEntry buildNetEntry = new NetEntry();
        buildNetEntry.setNet(netEntryDto.getNet());

        // TODO: Validate for duplicate callsign

        //lookup station based on provided callsign
        stationService.lookupOrCreateStation(StationLookupDto.builder()
                .callsign(netEntryDto.getCallsign())
                .name(netEntryDto.getName())
                .build());


        return null;

    }


//
//    public List<NetType> getNetTypesForCurrentUser() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        User currentUser = null;
//
//        if (auth != null && auth.getPrincipal() instanceof UserDetails) {
//            currentUser = ((UserDetails) auth.getPrincipal()).getUsername();
//        }
//
//        List<NetType> netTypes = new ArrayList<>();
//
//
//        return
//    }

}
