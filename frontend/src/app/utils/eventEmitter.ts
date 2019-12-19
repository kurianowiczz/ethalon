class EventEmitter {
  events = {};
  subscribe = (event: string, handler: Function) => {
    if (this.events[event]) {
      this.events[event].push(handler);
    } else {
      this.events[event] = [handler];
    }
  };
  emit = (event: string) => {
    if (this.events[event]) {
      for (const handler of this.events[event]) {
        handler();
      }
    }
  };
}

const instance = new EventEmitter();

export default instance;
