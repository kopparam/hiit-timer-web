#!/usr/bin/env bash

helm repo add bitnami https://charts.bitnami.com/bitnami

kubectl create namespace springfun

helm upgrade --install appdb bitnami/postgresql \
  --namespace springfun \
  --wait --timeout 1m

helm upgrade --install webapp ./helm/springfun \
  --namespace springfun \
  --values ./helm/local.yaml \
  --wait --timeout 1m