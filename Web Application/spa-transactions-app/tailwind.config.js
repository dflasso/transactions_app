/** @type {import('tailwindcss').Config} */
const colors = require('tailwindcss/colors')

module.exports = {
  content: [
    "./src/**/*.{html,ts}",
  ],
  theme: {
    colors: {
      orange: {
        '50': '#fcf8ea',
        '100': '#f8f0c9',
        '200': '#f3de95',
        '300': '#ebc759',
        '400': '#e3ad2c',
        '500': '#d4971e',
        '600': '#c27c19',
        '700': '#925416',
        '800': '#79431a',
        '900': '#68381b',
        '950': '#3c1d0c',
      },
      gray: {
        '50': '#f7f7f7',
        '100': '#f0f0f0',
        '200': '#e3e3e3',
        '300': '#d1d1d1',
        '400': '#bfbfbf',
        '500': '#aaaaaa',
        '600': '#969696',
        '700': '#818181',
        '800': '#6a6a6a',
        '900': '#585858',
        '950': '#333333',
      },
      red: {
        '50': '#fef2f2',
        '100': '#ffe1e1',
        '200': '#ffc8c8',
        '300': '#ffadad',
        '400': '#fd6c6c',
        '500': '#f53e3e',
        '600': '#e22020',
        '700': '#be1717',
        '800': '#9d1717',
        '900': '#821a1a',
        '950': '#470808',
      },
      black: colors.black,
      white: colors.white,
      green: colors.emerald,
      purple: colors.violet,
      yellow: colors.amber,
      pink: colors.fuchsia,
      blue: colors.blue
    },
    extend: {},
  },
  plugins: [],
}

