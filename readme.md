## Install
```shell
npm install fluid-xb-tools --save-dev
```

## Quick Start
``` javascript
import {fluid} from 'fluid-xb-tools'
import 'fluid-xb-tools/fluid.css'

// init
export default {
  data () {
    return {
      ,,,
    }
  },
  created() {
    this.fluidObject = new fluid()
    this.fluidObject.init()
  },
  methods: {
    openFluid: function () {
      // open fluid
      this.fluidObject.openDialog(iframeUrl)
    }
  }
}
```

## Browser Support
Modern browsers and Internet Explorer 10+.
