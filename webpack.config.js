'use strict';

const path = require('path');

module.exports = {
  context: path.join(__dirname, './assets'),
  entry: {
    bundle: './js/app.js',
  },
  output: {
    path: path.join(__dirname, './public/assets'),
    filename: '[name].js'
  }
};
