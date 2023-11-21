import { CapacitorConfig } from '@capacitor/cli';

const config: CapacitorConfig = {
  appId: 'com.example.nbaapk',
  appName: 'nbaApk',
  webDir: 'dist',
  server: {
    androidScheme: 'https'
  }
};

export default config;
