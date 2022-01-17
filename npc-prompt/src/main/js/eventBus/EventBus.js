import { Subject, Observable } from 'rxjs'
import { concatMap } from 'rxjs/operators';


class EventBus{

    static events = {};
    static subject;

    static{
        EventBus.subject = new Subject();

        EventBus.subject.subscribe({
            next: (event)=>{
                let subscribers = EventBus.events[event.name];
                if(subscribers){
                    subscribers.forEach(subscriber => subscriber.next(event.data));
                }
            }
        });
    }

    static emit(eventName, data){
        console.log(`Event Emitted: ${eventName}`);
        EventBus.subject.next({name: eventName, data: data})
    }

    static on(eventName){
        console.log(`Subscribe to event: [${eventName}]`)
        let s = new Subject();
        if(!EventBus.events.hasOwnProperty(eventName)){
            EventBus.events[eventName] = [];
        }
        EventBus.events[eventName].push(s);
        return s;
    }

}

export default EventBus