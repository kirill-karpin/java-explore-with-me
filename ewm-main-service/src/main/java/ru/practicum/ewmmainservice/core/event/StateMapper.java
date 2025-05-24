package ru.practicum.ewmmainservice.core.event;

import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
public class  StateMapper {

    @Named("stateActionToState")
    EventState mapState(EventStateAction stateAction) {
        if (stateAction == null) {
            return null;
        }
        switch (stateAction) {
            case SEND_TO_REVIEW:
                return EventState.PENDING;
            case CANCEL_REVIEW:
                return EventState.CANCELED;
            case PUBLISH_EVENT:
                return EventState.PUBLISHED;
            default:
                throw new IllegalArgumentException("Unknown state action: " + stateAction);
        }
    }

    @Named("stateToStateAction")
    EventStateAction mapStateAction(EventState state) {
        if (state == null) {
            return null;
        }
        switch (state) {
            case PENDING:
                return EventStateAction.SEND_TO_REVIEW;
            case CANCELED:
                return EventStateAction.CANCEL_REVIEW;
            case PUBLISHED:
                return EventStateAction.PUBLISH_EVENT;
            default:
                throw new IllegalArgumentException("Unknown state: " + state);
        }
    }
}
