## Install
```shell
npm install fluid-payment-js --save-dev
```

## Quick Start
``` javascript
import {fluid} from 'fluid-payment-js'
import 'fluid-payment-js/fluid.css'

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
      this.fluidObject.loadFluidPayment(iframeUrl)
    }
  }
}
```

## Browser Support
Modern browsers and Internet Explorer 10+.
